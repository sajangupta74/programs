def block_test(number)
  puts "We're in the method!"
  puts "going to the block..."
  yield number
  puts "We're back in the method!"
  yield 10,100,1000
end

block_test(457889) {|n,k| puts ">>> We're in the block! #{n} #{k}" }