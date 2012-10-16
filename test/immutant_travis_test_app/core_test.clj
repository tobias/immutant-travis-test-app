(ns immutant-travis-test-app.core-test
  (:use clojure.test
        immutant-travis-test-app.core)
  (:require [immutant.messaging :as msg]))

(deftest a-test
  (Thread/sleep 5000)
  (msg/publish "queue/ham" "gravy")
  (is (= "GRAVY" (msg/receive "queue/biscuit"))))
