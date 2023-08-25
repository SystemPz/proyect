import { Breadcrumb, Button, Card, Col, Form, Input, Row } from 'antd';
import { Link } from 'react-router-dom';
import { HomeOutlined, PlusCircleOutlined } from '@ant-design/icons';
import React, { useEffect, useState } from 'react';
import CitizenTable from './CitizenTable';
import CitizenService from '../../responseService/CitizenService';
import { Loading } from '../../resource/constants';
import alerts from '../../resource/alerts';

export default function CitizenHome() {
  const [citizens, setCitizens] = useState([]);
  const [loading, setLoading] = useState(false);

  const getCitizen = async () => {
    setLoading(true);
    const response = await CitizenService.getCitizenAll();
    console.log(JSON.stringify(response))
    setLoading(false);
    if (!response.success) return;
    setCitizens(response.citizens);
  }

  useEffect(() => {
    getCitizen();
  }, [])

  const deleteCitizen = async (id) => {
    setLoading(true);
    const response = await CitizenService.deleteCitizen(id);
    setLoading(false);
    if (!response.success) return;
    alerts.success("", response.message);
    await getCitizen();
  }

  return (
    <>
      <Breadcrumb style={{ margin: '16px 0', }} >
        <Breadcrumb.Item>
          <Link to='/'><HomeOutlined /></Link>
        </Breadcrumb.Item>
        <Breadcrumb.Item>Ciudadano</Breadcrumb.Item>
      </Breadcrumb>

      <Loading loading={loading}>
        <Card title={`Ciudadanos`}>
          <Row gutter={[16, 16]} style={{ marginBottom: "0px" }}>
            <Col xs={24} md={12} xl={8} style={{ alignContent: 'right' }}>
              <Form.Item label="Nuevo registro">
                <Link to={`/Citizen/Add`} className="text-decoration-none text-dark">
                  <Button shape="round" icon={<PlusCircleOutlined style={{ fontSize: '12px' }} />} block>
                    Nuevo
                  </Button>
                </Link>
              </Form.Item>
            </Col>
          </Row>
          <CitizenTable dataSource={citizens} deleteCitizen={deleteCitizen} />
        </Card>
      </Loading>
    </>
  );
}
