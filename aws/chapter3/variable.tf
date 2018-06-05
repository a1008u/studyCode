variable "aws_access_key" {}
variable "aws_secret_key" {}

variable "region" {
  default = "ap-northeast-1"
}

variable "amis" {
  type = "map"

  default = {
    us-east-1      = "ami-13be557e"
    us-west-2      = "ami-21f78e11"
    ap-northeast-1 = "ami-1bfdb67c"
  }
}

variable "key_name" {
  description = "Desired name of AWS key pair"
}

variable "public_key_path" {
  description = <<DESCRIPTION
Path to the SSH public key to be used for authentication.
Ensure this keypair is added to your local SSH agent so provisioners can
connect.

Example: /Users/a_uemoto/.ssh/terraform.pub
DESCRIPTION
}
