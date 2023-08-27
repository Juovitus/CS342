//Question 1
//a
(let((problem1 (ref 420))) (let ((parta problem1)) (deref parta)))
//Output of //a
$ (let((problem1 (ref 420))) (let ((parta problem1)) (deref parta)))
420
//b(i)
(define find(lambda (head x)(if (= (getFst head) x) head (if (null? (deref (getSnd head)))(list)(find (deref (getSnd head)) x)))))
//b(ii)
(define insertNode(lambda (head ele x)(if (null? (find head x)) head (insertAfter (find head x) ele))))


(define insertAfter(lambda (found ele)(if (null? (getSnd found))(set! (getSnd found) ele)
(if (null? (set! (getSnd ele) (deref (getSnd found))))(set! (getSnd found) ele) (set! (getSnd found) ele)))))