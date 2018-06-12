variable "region" {}
variable "aws_access_key" {}
variable "aws_secret_key" {}
variable "eip_allocation_id" {}

# aws
provider "aws" {
  access_key = "${var.aws_access_key}"
  secret_key = "${var.aws_secret_key}"
  region     = "${var.region}"
}

# インスタンス生成に利用する(pemを利用する場合はpemを指定)
variable "key_name" {
  description = "Desired name of AWS key pair"
}

variable "amis" {
  type = "map"

  default = {
    us-east-1      = "ami-13be557e"
    us-west-2      = "ami-21f78e11"
    ap-northeast-1 = "ami-1bfdb67c"
  }
}

# オレオレ認証を利用する場合に利用
variable "public_key_path" {
  description = <<DESCRIPTION
Path to the SSH public key to be used for authentication.
Ensure this keypair is added to your local SSH agent so provisioners can
connect.

Example: /Users/a_uemoto/.ssh/terraform.pub
DESCRIPTION
}
