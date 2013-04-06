(ns algo3.server)

(use 'lamina.core 'aleph.tcp 'gloss.core)

(defn handle-msg [channel msg]
  (println "got message" msg)
  (enqueue channel (str "you said " msg)))

(defn handler [ch client-info]
  (receive-all ch
;;    #(enqueue ch (str "You said " %))))
      #(handle-msg ch %)))

(defn -main []
      (start-tcp-server handler {:port 10000, :frame (string :utf-8 :delimiters ["\r\n"])}))
