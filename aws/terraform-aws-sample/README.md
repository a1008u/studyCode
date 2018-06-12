## 概要
「Amazon Web Services 基礎からのネットワーク&サーバー構築 改訂版」を用いて、terraformとawsを理解する

## Installation
```
$ brew install terraform
```

## Usage
Edit `terraform.tfvars.sample` and save as `terraform.tfvars`.
```
access_key = "AWS_ACCESS_KEY"
secret_key = "AWS_SECRET_KEY"
region     = "ap-northeast-1"
key_name   = "KEY_PAIR_NAME"
```

Execute
```
$ terraform init
$ terraform plan
$ terraform apply
```
