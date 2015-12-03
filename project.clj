(defproject correo "0.1.0-SNAPSHOT"
  :description "A simple email sender with an HTTP interface"
  :url "https://github.com/chetbox/correo"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-json "0.4.0"]
                 [com.draines/postal "1.11.3"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler correo.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
