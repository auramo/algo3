(ns algo3.algoserver
  (:use [algo3.messagetransport]
        [clojure.tools.trace]))

(defn handle-msg [channel msg]
  (trace "got message" msg)
  (send-message channel {:msgType "join" :data "The SERVER"})
  (send-message channel {:msgType "initialize" :data "The SERVER"})
  (send-message channel {:msgType "start" :data "The SERVER"})
  (send-message channel {:msgType "competitionmessage" :data "stuff"})
  (send-message channel {:msgType "end" :data "The SERVER"}))

(defn -main []
  (start-server handle-msg 10000))
