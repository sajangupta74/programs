=begin
What happens if you try to access a key that doesn't exist, though?

In many languages, you'll get an error of some kind. Not so in Ruby: you'll instead get the special value
nil.

Along with false, nil is one of two non-true values in Ruby. (Every other object is regarded as "truthy,"
 meaning that if you were to type if 2 or if "bacon", the code in that if statement would be run.)

It's important to realize that false and nil are not the same thing: false means "not true," while nil 
is Ruby's way of saying "nothing at all."
=end

creatures = { "weasels" => 0,
  "puppies" => 6,
  "platypuses" => 3,
  "canaries" => 1,
  "Heffalumps" => 7,
  "Tiggers" => 1
}
puts creatures["puppy"]

breakfast = { "bacon" => "tasty",
  "eggs" => "tasty",
  "oatmeal" => "healthy",
  "OJ" => "juicy"
}

my_hash.each do |key, value|
  puts key, my_hash[key]
end


=begin
You don't have to settle for nil as a default value, however. If you create your hash using the Hash.new
syntax, you can specify a default like so:

my_hash = Hash.new("Trady Blix")
Now if you try to access a nonexistent key in my_hash, you'll get "Trady Blix" as a result.
=end

menagerie = { :foxes => 2,
  :giraffe => 1,
  :weezards => 17,
  :elves => 1,
  :canaries => 4,
  :ham => 1
}





=begin
However, the hash syntax has changed in Ruby 1.9. Just when you were getting comfortable!

The good news is that the new syntax is easier to type than the old hash rocket syntax, and if 
you're used to JavaScript objects or Python dictionaries, it will look very familiar:
=end

new_hash = { one: 1,
  two: 2,
  three: 3
}

=begin
The two changes are:

You put the colon at the end of the symbol, not at the beginning;
You don't need the hash rocket anymore.
It's important to note that even though these keys have colons at the end instead of the beginning, 
they're still symbols!
=end

puts new_hash