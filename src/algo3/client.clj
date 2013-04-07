(ns algo3.client
  (:use 
        [algo3.messagetransport]))

(defn start-sending []
  (loop [channel (start-client-channel "localhost" 10000)]
    (println "Sending message")
    (send-message channel {:foo "bar"})
    (println "Got reply:")
    (println (read-message channel))
    (Thread/sleep 3000)
    (recur channel)))

(defn -main[] (start-sending))
