def exampleMethod var1,proc
	proc.call(var1)
	puts "method end"
end


proc1 = Proc.new do |var|
	puts "calling proc:: #{var}"
end
puts "Inbetween proc and lambda"

lambda1 = lambda do |var|
	puts "calling lambda:: #{var}"
end
puts "After lambda definition"

exampleMethod "Sajan", proc1
puts "After passing proc1"
exampleMethod "Sajan", lambda1
puts "After passing lambda1"


def counter
  n = 0
  return Proc.new { n+= 1 }
end

a = counter
puts a.call            # returns 1
puts a.call            # returns 2

b = counter
puts b.call            # returns 1

puts a.call      




def foo
  f = lambda do |variable|
  	puts "5"
  	return "next called"
  	puts "6"
  end 
  puts f.call 9 # control leaves foo here
  return "return from foo" 
end
puts foo   