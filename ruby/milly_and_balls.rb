=begin

Milly and balls
Max. Marks 100


Milly is standing at the centre of a circle made by her friends. There are N people standing 
in a circle facing towards Milly as shown below. 2nd person is at the left of the 1st person 
and right of the 3rd one. Similarly Nth person ia at the right of the 1st person and at the 
left of the (N-1)th person. Milly has K balls initially with her. She starts from the 1st
 person's position and move in a clock-wise order. She will give i balls to every ith person 
 of this circle. She wants to complete the circle fully which means that if at some instant 
 she is not able to give the balls due to lack of required number of balls then she will require
  some P number of additional balls in order to complete the circle and then she will stop.
  enter image description here

Note : Milly can complete the circle any number of time till she has the required 
number of balls but once it is not possible to give the balls as per the requirement 
then she will take those P additional balls to complete the circle and then she will 
stop. If she is able to complete the circle some number of times using those K balls 
then she will not require any additional balls.



Input

First line of the input will contain a integer T (number of test cases).
Then for every test case there will be one line containing two space separated integers N and K.
Output

For every test case, print the value of P in a new line.
Constraints

1 ≤ T ≤ 105
1 ≤ N ≤ 109
0 ≤ K ≤ 109
Sample Input(Plaintext Link)
 2
5 13
2 4
Sample Output(Plaintext Link)
 2
2

=end


def method(n,k)
	sum = (n*(n+1))/2

	if k > sum
		if k%sum == 0
			return 0
		else
			d = (k/sum).floor
		end
		k = k - sum*d
	end

	return sum - k
end

n = Array.new
k = Array.new
o = Array.new

#Enter number of test cases
t = gets.to_i

t.times do |i|
	temp = Array.new

	#Enter number of people and balls space seperated
	temp = gets.to_s.split(" ").map{|n| n.to_i}

	n[i] = temp[0]
	k[i] = temp[1]

	o[i] = method(n[i],k[i])
end


#printing output
t.times do |i|
	puts o[i]
end