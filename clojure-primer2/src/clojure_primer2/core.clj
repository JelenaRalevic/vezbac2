
(ns clojure-primer2.core
  (:require [clojure.string :as str])
  (:gen-class))

(use 'clojure.java.io)

(defn upisi-u-file
  [imefajla  tekst]
  (with-open [wrtr (writer imefajla)]
    (.write wrtr tekst)
    )
  )



(defn dodati-fajl
  [file text]
  (with-open [wrtr (writer file :append true)]
    (.write wrtr text)
    )  
  )
(defn citaj-liniju-iz-texta
  [file]
  (with-open [rdr (reader file)]
    (doseq [line (line-seq rdr)]
      (println line)
      )
    )
  )



(odd? 15)
(even? 12)
(pos? -150)
(neg? -25)

(defn atom-pre
  [x]
  (def atomPree (atom x))
  (add-watch atomPree :watcher
       (fn [key atom pre posle]
         (println "atom neki promenjen iz" pre " u " posle )
         ))
  (println "1. x" @atomPree)
  (reset! atomPree 10)
  (println "2. x" @atomPree)
  (swap! atomPree inc)
  (println "Increment je sada x" @atomPree)
  )

(defn atom-ja
  [x]
  (def jaPokusaj (atom x))
  (fn [key atom pre posle]
(println "Pre: " pre " u " posle)
    )
  (println "1.x" @jaPokusaj)
  (reset! jaPokusaj 10)
  (println "2.x" @jaPokusaj)
  (swap! jaPokusaj inc)
  (println "Increment x" @jaPokusaj)
  )

(defn agent-pr
  []
  (def karte-prodate (agent 0))
  (send karte-prodate + 15)
  (println)
  (println "Karte: " @karte-prodate)
  
  (send karte-prodate + 10)
  (await-for 100 karte-prodate)
  (println "Karte: " @karte-prodate)
  
  (shutdown-agents)
  )


(defn moze-glasati
  [god]
  (if(>= god 18)
    (println "Mozes glasati")
   (println "Ne mozes glasati")
    )
  )

(defn moze-vise
  [god]
  (if(>= god 18)
    (do (println "Pored glasanja mozes voziti")
        (println "Kao sto sam napisala, mozes glasati"))
    (println "Ne mozes voziti ni glasati!")

    )

  )

(defn when-metoda
  [x]
  (when x
    (println "Ovo je tacno")
    (println "Ovo je sta?")
    )
  )
(defn koji-razred-si
  [god]
  (cond (< god 5)(println "Ti si u vrticu")
        (= god 5)(println "Kreces u skolu")
       (and (> god 5)(<= god 18))(format "Ides u razred %d" (- god 5))
            
       :else "Ides na fakultet!Bravo"
       )

  )
;;PETLJE
(defn jedan-do-x
  [x]
  (def i (atom 1))
  (while (<= @i x)
    (do (println @i)
        (swap! i inc)
        )
    )

  )
(defn dupliraj
  [x]
  (dotimes [i x]
    (println (* i 2))
    )
)

(defn triputa
  [x y]
  (loop [i x]
    (when (< i y)
      (println (* i 3))
      (recur (+ i 1))
        )
    )
 )

(defmacro popust
  ([cond d1 d2]
   (list 'if cond  d1 d2
    )   
   )
  )


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  
  (popust (> 75 65)(println "10% popusta")(println "puna cena") )
  )
  
  ;(upisi-u-file "test.txt" "Da li radi?\n ")
  ;(dodati-fajl "test.txt" "Druga recenica!")
  ;(citaj-liniju-iz-texta "test.txt")


  
  ;;(jedan-do-x 4)
 ;; (dupliraj 5)
  ;;(triputa 1 5 )



  
  ;;(koji-razred-si 15)
  
 ;; (when-metoda true)





  
  ;;(moze-vise 25)
  
  ;;(atom-pre 5)
  ;;(atom-ja 7)



  
 ;; (def along 15)
  ;; (nil?  along)
;; (def jeca  "Jelena!")
  ;;(def lgn 15)
  ;;(format "Ovo je string %s" jeca)
  ;;(format "5 razmaka %5d" lgn)
  ;;(format "nule %04d" lgn)
  ;;(format "%-4d levo poravnjanje" lgn)
 ;; (def str1 "Ovo je string. ")
  ;;(str/blank? str1)
  ;;(str/includes? str1 "je")
 ;; (str/split str1 #" " )
  ;;(str/replace str1 #"je" "je super")
  ;;(println (list* "Jelena" 21 "godina" [58]))
  
  
  
 

