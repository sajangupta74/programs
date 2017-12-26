class Node
	attr_accessor :left, :right, :value

	def initialize
		@left, @right, @value = nil, nil, nil
	end
end



class Bst
	attr_accessor :root
	
	def initialize 
		@root = Node.new
		puts "Enter root value"
		@root.value = gets.chomp.to_i
		@root.left, @root.right = nil, nil
	end


	def insert
		choice = "no"
		temp = Node.new
		puts "Enter the value "
		temp.value = gets.chomp.to_i
		ele = temp.value

		node = surfToLastElement temp.value, @root

		if node.value > ele 
			node.left = temp
		else
			node.right = temp
		end

		puts "want to insert more? yes/no "
		choice = gets.chomp.to_s

		if choice.eql?("yes")
			self.insert
		end

	end


	def surfToLastElement ele, root
		
		if root.value > ele && root.left != nil
			root = self.surfToLastElement ele, root.left
		elsif root.value < ele && root.right != nil
			root = self.surfToLastElement ele, root.right
		end
		if root.left == nil || root.right == nil
			return root
		end
	
	end


	def preOrder root = @root
		
		puts root.value
		
		if root.left != nil 
			self.preOrder root.left
		end

		if root.right != nil
			self.preOrder root.right
		end
	end

end


obj = Bst.new 
obj.insert
obj.preOrder 