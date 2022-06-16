from flask import Flask, Response
import json
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

customers = [
    dict(name='Vinod Kumar', email='vinod@vinod.co', phone='9731424784', city='Bangalore'),
    dict(name='Ramesh Kumar', email='ramesh@xmpl.com', phone='9731424711', city='Vasco'),
    dict(name='Harish Kumar', email='haris@xmpl.com', phone='9731424333', city='Mumbai')
]


@app.route('/api/customers', methods=['GET'])
def all_customers():
    return Response(json.dumps({'customers': customers}), mimetype='application/json')


@app.route('/api/customers/info', methods=['GET'])
def info():
    return """
This is a simple REST endpoint
exposing customer details at
http://localhost:1234/api/customers

This current response came from 
http://localhost:1234/api/customers/info
    """


if __name__ == '__main__':
    app.run(port=1234, debug=True)