
=begin
Remember when we told you that everything is an object in Ruby? Well, we sort of fibbed. Blocks are not 
objects, and this is one of the very few exceptions to the "everything is an object" rule in Ruby.

Because of this, blocks can't be saved to variables and don't have all the powers and abilities of a real
#object. For that, we'll need... procs!

You can think of a proc as a "saved" block: just like you can give a bit of code a name and turn it into 
a method, you can name a block and turn it into a proc. Procs are great for keeping your code DRY, which 
stands for Don't Repeat Yourself. With blocks, you have to write your code out each time you need it; 
with a proc, you write your code once and can use it many times!
=end



#first Example
multiples_of_3 = Proc.new do |n|
  n % 3 == 0
end

arr = (1..100).to_a.select(&multiples_of_3)
for i in 0..arr.length
	puts arr[i]
end





#Second Example

floats = [1.2, 3.45, 0.91, 7.727, 11.42, 482.911]
# Write your code below this line!
round_down = Proc.new {|n| n.floor }
    


# Write your code above this line!
ints = floats.collect(&round_down)
for i in 0..ints.length
	puts ints[i]
end





#Third Example
def greeter 
    yield
end

phrase = Proc.new { puts "Hello there!" }

greeter &phrase

#another way of calling proc
phrase.call
