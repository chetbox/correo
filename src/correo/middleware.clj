(ns correo.middleware
  (:require [clojure.walk :refer [keywordize-keys]]))

(defn wrap-body-keywordize-keys
  [app]
  (fn [req]
    (app (assoc req
                :body (keywordize-keys (:body req))))))
