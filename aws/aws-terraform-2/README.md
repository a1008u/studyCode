## Installation
```
$ brew install terraform
$ git clone git@github.com:litencatt/terraform-aws-templates.git
```

## Usage
Edit `terraform.tfvars.sample` and save as `terraform.tfvars`.
```
access_key = "AWS_ACCESS_KEY"
secret_key = "AWS_SECRET_KEY"
region     = "ap-northeast-1"
key_name   = "KEY_PAIR_NAME"
eip =　"your_eip"
```

Execute
```
$ terraform init
$ terraform plan
$ terraform apply
```
nginx
```
sudo yum update
sudo yum install nginx
nginx -v
sudo service nginx start
sudo chkconfig nginx on

cd /var/www/html
touch index.html
vim index.html
```