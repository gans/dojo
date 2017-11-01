Euclid's Algorithm c++ implementation
======================================

Abstract
========

Given two positive integers m and n, find their greatest common divisor,
that is, the largest positive integer that evenly divides both m and n.

E1. [Find remainder.] Divide m by n and let r be the raminder. (We will have 0<= r < n.)

E2. [It is zero?] If r = 0, the algorithm terminates; n is the answer.

E3. [Reduce.] Set m <- n, n -< r, and go back to step E1.


