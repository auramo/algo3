(ns algo3.messagetransport
  (:require [clojure.data.json :as json])
  (:use [lamina.core]
        [aleph.tcp]
        [gloss.core]
        [clojure.tools.trace]))

(def msg-separator "\r\n")

(defn- json->clj [string]
  (json/read-str string :key-fn keyword))

(defn create-handler [msg-callback]
  (fn [ch client-info]
    (receive-all ch #(msg-callback ch (json->clj %)))))

(defn start-client-channel [host port]
  (wait-for-result
   (tcp-client {:host host,
                :port port,
                :frame (string :utf-8 :delimiters [msg-separator])})))

;; Send a clojure map structure which is encoded to json internally here
(defn send-message [channel message]
  (enqueue channel (json/write-str message)))

(defn read-message [channel]
  (json->clj (wait-for-message channel)))

(defn start-server [msg-callback port]
  (trace "Starting server on port" port)
  (start-tcp-server (create-handler msg-callback) {:port port, :frame (string :utf-8 :delimiters [msg-separator])}))

