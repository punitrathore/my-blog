(ns my-blog.webserver
  (:use [compojure.core]
        [ring.adapter.jetty]
        [address_book.routes :as routes]))

 (future (run-jetty index {:port 8080}))
