(ns my-blog.webserver
  (:use [compojure.core]
        [ring.adapter.jetty]
        [my-blog.routes :as routes]))

(defn start
  "Start Jetty in a background thread.  Note there's currently no
  way to stop Jetty once you start it."
  []
  (future
   (run-jetty (var post-routes) {:port 8080})))
