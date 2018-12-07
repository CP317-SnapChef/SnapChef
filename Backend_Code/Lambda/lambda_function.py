import json
import sys
import pymysql


rds_host  = "snapchefdbinstance.chvgyyoopqkx.us-east-2.rds.amazonaws.com:3306"
name = "backend"
password = "Snapchef2018"
db_name = "snapchefdbinstance"


ResCode=""

try:
    conn = pymysql.connect(rds_host, user=name, passwd=password, db=db_name, connect_timeout=5)
    ResCode="Good"
except Exception as e:
    ResCode="Fail"
    print(e)
    sys.exit()


def lambda_handler(event, context):
    return {
        'statusCode': 200,
        'body': json.dumps(ResCode)
    }
