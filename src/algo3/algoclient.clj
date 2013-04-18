(ns algo3.algoclient
  (:use [algo3.messagetransport]
        [clojure.tools.trace]))

(defmulti handle-msg :msgType)

(defmethod handle-msg "join" [msg] 
  (trace "Join called with message" msg)
  true)

(defmethod handle-msg "initialize" [msg] 
  (trace "Initialize called with message" msg)
  true)

(defmethod handle-msg "start" [msg] 
  (trace "start called with message" msg)
  true)

(defmethod handle-msg "competitionmessage" [msg] 
  (trace "competitionmessage called with message" msg)
  true)

(defmethod handle-msg "end" [msg] 
  (trace "End called with message" msg)
  false)

(defn conversation [channel]
  (let [msg (read-message channel)]
    (when (handle-msg msg) (recur channel))))

(defn start-client []
  (let [channel (start-client-channel "localhost" 10000)]
    (send-message channel {:msgType "join" :data "Donkeytron 2000"})
    (conversation channel)))

(defn -main[] (start-client))

