(ns correo.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.util.response :refer [response]]
            [correo.email :as email]
            [correo.middleware :refer [wrap-body-keywordize-keys]]))

(defn read-config
  [file]
  (read-string (slurp file)))

(defn app-routes
  [config]
  (let [email-sender (email/sender config)]
    (routes
      (GET "/"
        []
        "Hello Email")
      (POST "/send"
        {message :body}
        (email/send! email-sender message)
        (response "ok\n"))
      (route/not-found "Not Found"))))

(defn app
  [config]
  (-> config
    app-routes
    wrap-body-keywordize-keys
    wrap-json-body
    wrap-json-response
    (wrap-defaults api-defaults)))

(def app-with-default-config
  (app (read-config "config/email.edn")))
