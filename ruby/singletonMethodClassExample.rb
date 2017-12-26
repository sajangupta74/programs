First, a little definition: a singleton method is a method that is defined only for a single object. Example:

irb(main):001:0> class Foo; def method1; puts 1; end; end
=> nil
irb(main):002:0> foo = Foo.new
=> #<Foo:0xb79fa724>
irb(main):003:0> def foo.method2; puts 2; end
=> nil
irb(main):004:0> foo.method1
1
=> nil
irb(main):005:0> foo.method2
2
=> nil
irb(main):006:0> other_foo = Foo.new
=> #<Foo:0xb79f0ef4>
irb(main):007:0> other_foo.method1
1
=> nil
irb(main):008:0> other_foo.method2
NoMethodError: undefined method `method2' for #<Foo:0xb79f0ef4>
        from (irb):8
Instance methods are methods of a class (i.e. defined in the class's definition). Class methods are singleton methods on the Class instance of a class -- they are not defined in the class's definition. Instead, they are defined on the singleton class of the object.

irb(main):009:0> Foo.method_defined? :method1
=> true
irb(main):010:0> Foo.method_defined? :method2
=> false
You open the singleton class of an object with the syntax class << obj. Here, we see that this singleton class is where the singleton methods are defined:

irb(main):012:0> singleton_class = ( class << foo; self; end )
=> #<Class:#<Foo:0xb79fa724>>
irb(main):013:0> singleton_class.method_defined? :method1
=> true
irb(main):014:0> singleton_class.method_defined? :method2
=> true
irb(main):015:0> other_singleton_class = ( class << other_foo; self; end )
=> #<Class:#<Foo:0xb79f0ef4>>
irb(main):016:0> other_singleton_class.method_defined? :method1
=> true
irb(main):017:0> other_singleton_class.method_defined? :method2
=> false
So an alternative means of adding singleton methods to an object would be to define them with the object's singleton class open:

irb(main):018:0> class << foo; def method3; puts 3; end; end
=> nil
irb(main):019:0> foo.method3
3
=> nil
irb(main):022:0> Foo.method_defined? :method3
=> false
In summary:

methods must always belong to a class (or: be instance methods of some class)
normal methods belong to the class they're defined in (i.e. are instance methods of the class)
class methods are just singleton methods of a Class
singleton methods of an object are not instance methods of the class of the object; rather, they are instance methods of the singleton class of the object.