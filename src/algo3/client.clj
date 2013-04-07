(ns algo3.client
  (:use [lamina.core]
        [algo3.messagetransport]
        [clojure.data.json]))

(defn send-msg []
  (let [ch (start-client-channel "localhost" 10000)]
    (println "sending message")
    (send-message ch {:foo "bar"})
    (println "sent the message, got reply")
    (println (read-str (wait-for-message ch)))))

(defn -main[] (send-msg))
