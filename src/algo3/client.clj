(ns algo3.client
  (:use [algo3.messagetransport]
        [clojure.tools.trace]))

(defn start-sending []
  (loop [channel (start-client-channel "localhost" 10000)]
    (trace "Sending message")
    (send-message channel {:foo "bar"})
    (trace "Got reply:")
    (trace (read-message channel))
    (Thread/sleep 3000)
    (recur channel)))

(defn -main[] (start-sending))
