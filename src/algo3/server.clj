(ns algo3.server)

(use 'lamina.core 'aleph.tcp 'gloss.core 'algo3.messagetransport)

(defn handle-msg [channel msg]
  (println "got message" msg)
  (enqueue channel (str "you said " msg)))

(defn -main []
  (start-server handle-msg 10000))
