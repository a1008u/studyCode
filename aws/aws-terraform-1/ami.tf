data "aws_ami" "amazon_linux" {
  most_recent = true
  owners      = ["amazon"]

  filter {
    name   = "name"
    values = ["amzn-ami-hvm-*-x86_64-gp2"]
  }
}

variable "amis" {
  type = "map"

  default = {
    nat = "ami-27d6e626"
  }
}
