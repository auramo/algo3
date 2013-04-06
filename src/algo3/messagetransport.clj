(ns algo3.messagetransport)

(use 'lamina.core 'aleph.tcp 'gloss.core)

(def msg-separator "\r\n")

(defn create-handler [msg-callback]
  (fn [ch client-info]
    (receive-all ch #(msg-callback ch %))))

(defn start-client-channel [host port]
  (wait-for-result
   (tcp-client {:host host,
                :port port,
                :frame (string :utf-8 :delimiters [msg-separator])})))


(defn start-server [msg-callback port]
  (println "Starting server on port" port)
  (start-tcp-server (create-handler msg-callback) {:port port, :frame (string :utf-8 :delimiters [msg-separator])}))

