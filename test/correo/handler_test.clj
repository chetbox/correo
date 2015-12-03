(ns correo.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [correo.handler :refer :all]))

(deftest test-app
  (testing "/"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello Email"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
