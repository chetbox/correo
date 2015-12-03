(ns correo.core
  (:gen-class)
  (:require [org.httpkit.server :refer [run-server]]
            [correo.handler :refer [app read-config]]))

(defn -main
  [config-file port-str & _]
  (println "Starting server with config" config-file "on port" port-str)
  (run-server (app (read-config config-file)) {:port (Integer/parseInt port-str)}))
