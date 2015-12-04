(ns correo.debug
  (:require [correo.handler :as handler]))

(def app
  (handler/app (handler/read-config "config/email.edn")))
