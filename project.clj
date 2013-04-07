(defproject algo3 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :aliases {"server" ["run" "-m" "algo3.server"]
            "client" ["run" "-m" "algo3.client"]}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [aleph "0.3.0-beta15" :exclusions [lamina]]
                 [lamina "0.5.0-beta15"]
                 [org.clojure/data.json "0.2.1"]
                 [org.clojure/tools.trace "0.7.5"]
                 [org.clojure/tools.nrepl "0.2.2"]])
