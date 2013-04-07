(ns algo3.client
  (:use 
        [algo3.messagetransport]))

(defn send-msg []
  (let [ch (start-client-channel "localhost" 10000)]
    (println "sending message")
    (send-message ch {:foo "bar"})
    (println "sent the message, got reply:")
    (println (read-message ch))))

(defn -main[] (send-msg))
