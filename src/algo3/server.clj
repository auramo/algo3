(ns algo3.server
  (:use [algo3.messagetransport]
        [clojure.tools.trace]))

(defn handle-msg [channel msg]
  (trace "got message" msg)
  (send-message channel (assoc msg :x "y")))

(defn -main []
  (start-server handle-msg 10000))
