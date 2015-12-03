(ns correo.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.util.response :refer [response]]
            [clojure.pprint :as pprint]
            [correo.email :as email]
            [correo.middleware :refer [wrap-body-keywordize-keys]]))

(def config (read-string (slurp "config/email.edn")))

(println "Using config:" (email/description config))

(defroutes app-routes
  (GET "/"
    []
    "Hello Email")
  (POST "/send"
    {message :body}
    (println "Sending message to" (:to message))
    (response (email/send config message)))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
    (wrap-body-keywordize-keys)
    (wrap-json-body)
    (wrap-json-response)
    (wrap-defaults api-defaults)))
