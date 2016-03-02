(ns correo.email
  (:require [clojure.core.async :refer [>!! <! chan go]]
            [postal.core :as postal]
            [postal.support :refer [message-id]]))

(defn -send!
  [config message]
  (println "Sending:" (:subject message))
  (time (postal/send-message
          (:server config)
          (merge
            message
            {:from (:from config)
             :message-id #(message-id (:identifier config))}))))

(defn send!
  [channel message]
  {:pre [(:to message)
         (:subject message)
         (:body message)]}
  [message]
  (>!! channel message))

(defn sender
  [config]
  (let [buffer-size (or (:buffer-length config) 0)
        channel (chan buffer-size)]
    (go
      (while true
        (-send! config (<! channel))))
    channel))
