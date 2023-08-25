import { Breadcrumb, Button, Card, Col, Row } from 'antd';
import { HomeOutlined } from '@ant-design/icons';
import React from 'react';
import './home.css';
import { Link } from 'react-router-dom';
import IconUsuarios from '../../assets/icons/staff.png';

export default function Home() {
  return (
    <>
      <Breadcrumb style={{ margin: '16px 0', }} >
        <Breadcrumb.Item>
          <Link to='/'><HomeOutlined /> inicio</Link>
        </Breadcrumb.Item>
      </Breadcrumb>

      <Row gutter={[16, 16]} style={{ marginBottom: '16px', justifyContent: 'center' }}>
        <Col xs={24} md={12} xl={8}>
          <div className="card">
            <div className="card-body">
              <div className="d-flex no-block">
                <div className="me-3 align-self-center">
                  <span className="lstick d-inline-block align-middle"></span>
                  <img src={IconUsuarios} className="App-logo" alt="logo" />
                </div>
                <div className="align-self-center">
                  <h4 className="text-muted mt-2 mb-0">Total Ciudadanos</h4>
                  <h3>236,000</h3>
                </div>
              </div>
            </div>
          </div>
        </Col>
      </Row>
    </>

  );
}