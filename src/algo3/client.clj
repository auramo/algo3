(ns algo3.client)

(use 'lamina.core 'aleph.tcp 'gloss.core 'algo3.messagetransport)

(defn send-msg []
  (let [ch (start-client-channel "localhost" 10000)]
      (enqueue ch "Hello, server!")
      (println "sent the message")
      (println (wait-for-message ch))))

(defn -main[] (send-msg))
