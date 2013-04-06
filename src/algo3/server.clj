(ns algo3.server)

(use 'lamina.core 'aleph.tcp 'gloss.core 'algo3.messagetransport 'clojure.data.json)

(defn handle-msg [channel msg]
  (println "got message" msg)
  (enqueue channel (write-str (assoc msg :x "y"))))

(defn -main []
  (start-server handle-msg 10000))
