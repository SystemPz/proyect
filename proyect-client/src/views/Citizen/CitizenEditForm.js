import React, { useState, useEffect, useCallback } from 'react';
import { Breadcrumb, Button, Card, Col, Form, Input, InputNumber, Row } from 'antd';
import { Link, useParams } from 'react-router-dom';
import { HomeOutlined } from '@ant-design/icons';
import { Loading, SearchSelect } from '../../resource/constants';
import CitizenService from '../../responseService/CitizenService';
import alerts from '../../resource/alerts';



export default function CitizenEditForm({ match }) {
    const { id } = useParams();
    const [form] = Form.useForm();
    const [loading, setLoading] = useState(false);

    const [citizens, setCitizens] = useState([]);

    const getCitizen = async () => {
        setLoading(true);
        const response = await CitizenService.getCitizenAll(id);
        console.log(JSON.stringify(response))
        setLoading(false);
        if (!response.success) return;
        setCitizens(response.citizens[0]);
        form.setFieldsValue({ ...response.citizens[0] })
    }
    useEffect(() => {
        if (id != null) {
            getCitizen();
        }
    }, [id]);


    const onFinish = async (values) => {
        let i = 0;
        if (values.address === undefined) {
            values.address = [];
        } else {
            values.address = values.address.map((row) => {
                return { key: i++, id: row.id, nameAddress: row.nameAddress, location: row.location, status: row.status == 1 ? true : false, };
            });
        }
        values.id = citizens.id
        values.identifier = citizens.identifier
        console.log(JSON.stringify(values))
        setLoading(true);
        const response = await CitizenService.newCitizen(values);
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
                <Breadcrumb.Item>
                    <Link to='/citizen'>Ciudadano</Link>
                </Breadcrumb.Item>
                <Breadcrumb.Item>Nuevo registro</Breadcrumb.Item>
            </Breadcrumb>

            <Loading loading={loading}>
                <Card title={`Editar registro: `}>
                    <Form form={form} layout='vertical' onFinish={onFinish} >


                        <Row gutter={[16, 16]} >
                            <Col xs={24} md={12} lg={8} xl={8}>
                                <Form.Item label={<>Nombre</>} name={'name'} rules={[{ required: true, message: '¡Este campo es requerible!', },]} >
                                    <Input placeholder="Nombre" />
                                </Form.Item>
                            </Col>
                            <Col xs={24} md={12} lg={8} xl={8}>
                                <Form.Item label={<>Primer Apellido</>} name={'firstLastName'} rules={[{ required: true, message: '¡Este campo es requerible!', },]} >
                                    <Input placeholder="Primer Apellido" />
                                </Form.Item>
                            </Col>
                            <Col xs={24} md={12} lg={8} xl={8}>
                                <Form.Item label={<>Segundo Apellido</>} name={'secondLastName'} rules={[{ required: true, message: '¡Este campo es requerible!', },]}>
                                    <Input placeholder="Segundo Apellido" />
                                </Form.Item>
                            </Col>
                            <Col xs={24} md={12} lg={8} xl={8}>
                                <Form.Item label={`Sexo`} name="gender" rules={[{ required: true, message: '¡Este campo es requerible!', },]}>
                                    <SearchSelect dataset={
                                        [
                                            { id: "H", description: 'H' },
                                            { id: "M", description: 'M' },
                                        ]
                                    } />
                                </Form.Item>
                            </Col>

                            <Col xs={24} md={24} lg={24} xl={24}>


                                <HomeAddress />
                            </Col>


                            <Col xs={24} md={12} lg={8} xl={8}>
                                <Form.Item label={<>.</>} >
                                    <Button type="primary" htmlType="submit" block>
                                        Guardar
                                    </Button>
                                </Form.Item>
                            </Col>
                        </Row>

                    </Form>
                </Card>
            </Loading>
        </>
    );
}

function HomeAddress() {
    return (
        <Form.List name="address">
            {(fields, { add, remove }) => (
                <>
                    {fields.map(({ key, name, ...restField }) => (
                        <Row key={key} gutter={[16, 16]} >

                            <Col xs={24} md={12} lg={8} xl={8}>
                                <Form.Item {...restField} label={<>Direccion</>} name={[name, 'nameAddress']} rules={[{ required: true, message: '¡Este campo es requerible!', },]} >
                                    <Input placeholder="Hidalgo #12" />
                                </Form.Item>
                            </Col>
                            <Col xs={24} md={12} lg={6} xl={6}>
                                <Form.Item {...restField} label={<>Localidad</>} name={[name, 'location']} rules={[{ required: true, message: '¡Este campo es requerible!', },]}>
                                    <Input placeholder="Benito Juarez" />
                                </Form.Item>
                            </Col>
                            <Col xs={24} md={12} lg={6} xl={6}>
                                <Form.Item {...restField} label={`Estatus`} name={[name, 'status']} rules={[{ required: true, message: '¡Este campo es requerible!', },]}>
                                    <SearchSelect dataset={
                                        [
                                            { id: 1, description: 'Activo' },
                                            { id: 2, description: 'Inactivo' },
                                        ]
                                    } />
                                </Form.Item>
                            </Col>
                            <Col xs={24} md={12} lg={4} xl={4}>
                                <Form.Item {...restField} label={<>.</>} name={[name, 'btn']} >
                                    <Button type="dashed" onClick={() => remove(name)} icon={<i className="bi bi-dash-circle-dotted me-2"></i>} danger block>
                                        Eliminar
                                    </Button>
                                </Form.Item>
                            </Col>
                        </Row>
                    ))}

                    <Form.Item label={<>Agregar Direcciones</>}>
                        <Button style={{ whith: '100%' }} type="dashed" onClick={() => add()} block icon={<i className="bi bi-plus-circle-dotted me-2"></i>}>
                            Agregar
                        </Button>
                    </Form.Item>

                </>
            )}
        </Form.List>
    );
}