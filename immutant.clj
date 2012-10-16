(ns immutant-travis-test-app.init
  ;(:use immutant-travis-test-app.core)
  (:require [immutant.messaging :as msg]
            [immutant.repl :as repl]
            [immutant.utilities :as util]))

(repl/start-nrepl 4006)
(msg/start "queue/ham")
(msg/start "queue/biscuit")
(msg/listen "queue/ham" (fn [m] (msg/publish "queue/biscuit" (.toUpperCase m))))

