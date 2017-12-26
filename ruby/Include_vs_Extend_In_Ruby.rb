Include vs Extend in Ruby

Now that we know the difference between an instance method and a class method, let’s cover the difference between include and extend in regards to modules. Include is for adding methods to an instance of a class and extend is for adding class methods. Let’s take a look at a small example.

module Foo
  def foo
    puts 'heyyyyoooo!'
  end
end

class Bar
  include Foo
end

Bar.new.foo # heyyyyoooo!
Bar.foo # NoMethodError: undefined method ‘foo’ for Bar:Class

class Baz
  extend Foo
end

Baz.foo # heyyyyoooo!
Baz.new.foo # NoMethodError: undefined method ‘foo’ for #<Baz:0x1e708>