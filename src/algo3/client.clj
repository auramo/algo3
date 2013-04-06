(ns algo3.client)

(use 'lamina.core 'aleph.tcp 'gloss.core)

 (def ch
  (wait-for-result
    (tcp-client {:host "localhost",
                 :port 10000,
                 :frame (string :utf-8 :delimiters ["\r\n"])})))

(defn send-msg [] 
      (enqueue ch "Hello, server!")
      (println "sent the message")
      (println (wait-for-message ch))
      (println "got message"))

(defn -main[] (send-msg))
