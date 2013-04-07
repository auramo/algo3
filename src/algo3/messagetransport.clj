(ns algo3.messagetransport
  (:use [lamina.core]
        [aleph.tcp] 
        [gloss.core] 
        [clojure.data.json]))

(def msg-separator "\r\n")

(defn create-handler [msg-callback]
  (fn [ch client-info]
    (receive-all ch #(msg-callback ch (read-str %)))))

(defn start-client-channel [host port]
  (wait-for-result
   (tcp-client {:host host,
                :port port,
                :frame (string :utf-8 :delimiters [msg-separator])})))

;; Send a clojure map structure which is encoded to json internally here
(defn send-message [channel message]
  (enqueue channel (write-str message)))

(defn read-message [channel]
  (read-str (wait-for-message channel)))

(defn start-server [msg-callback port]
  (println "Starting server on port" port)
  (start-tcp-server (create-handler msg-callback) {:port port, :frame (string :utf-8 :delimiters [msg-separator])}))

