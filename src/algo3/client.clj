(ns algo3.client)

(use 'lamina.core 'aleph.tcp 'gloss.core 'algo3.messagetransport 'clojure.data.json)

(defn send-msg []
  (let [ch (start-client-channel "localhost" 10000)
        msg (write-str {:foo "bar"})]
    (println "sending message" msg)
    (enqueue ch msg)
    (println "sent the message, got reply")
    (println (read-str (wait-for-message ch)))))

(defn -main[] (send-msg))
