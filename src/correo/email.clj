(ns correo.email
  (:refer-clojure :exclude [send])
  (:require [postal.core :as postal]
            [postal.support :refer [message-id]]))

(defn description
  [config]
  (str (:identifier config) " (" (get-in config [:server :host]) ")"))

(defn send
  [config message]
  {:pre [(:to message)
         (:subject message)
         (:body message)]}
  (postal/send-message
    (:server config)
    (merge message
           {:from (:from config)
            :message-id #(message-id (:identifier config))})))
