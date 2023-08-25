import { ScheduleOutlined, WindowsOutlined, BarChartOutlined } from '@ant-design/icons';
import { Layout, Menu, } from 'antd';
import React, { useState } from 'react';
import { Route, Routes, Link } from 'react-router-dom';

import './App.css';

import Home from '../views/Home/Home';
import CitizenHome from '../views/Citizen/CitizenHome';
import CitizenAddForm from '../views/Citizen/CitizenAddForm';
import CitizenEditForm from '../views/Citizen/CitizenEditForm';
const { Header, Sider, Footer } = Layout;

const navs = [
  {
    key: 1,
    label: <Link to='/'></Link>,
    icon: <WindowsOutlined />,
  },
  {
    key: 2,
    label: <Link to='/'></Link>,
    icon: <BarChartOutlined />,
  },

]

function App(props) {
  const [collapsed, setCollapsed] = useState(false);

  return (
    <Layout>
      <Header id="components-layout-demo-top-side-2">
        <div className="logo" />
        <Menu theme="dark" mode="horizontal" /*defaultSelectedKeys={['2']}*/ items={navs} />

      </Header>
      <Layout>
        <Sider width={250} className="site-layout-background" collapsible collapsed={collapsed} onCollapse={value => setCollapsed(value)}>
          <Menu
            theme='dark'
            style={{ height: "100vh", borderRight: 0 }}
            mode="inline"
            items={[
              {
                label: 'Directorio',
                key: '0',
                icon: <ScheduleOutlined />,
                children:
                  [
                    { label: <Link to='/citizen'>Ciudadanos</Link>, key: 'config-a', icon: <ScheduleOutlined />, },
                  ],
              },



            ]}
          />
        </Sider>
        <Layout style={{ padding: '0 24px 24px', }} >
          <Routes>
            <Route exact path="/" element={<Home />} />
            <Route exact path="/citizen" element={<CitizenHome />} />
            <Route exact path="/citizen/Add" element={<CitizenAddForm />} />
            <Route path={`/Citizen/Edit/:id`} element={<CitizenEditForm />} />
          </Routes>
          <Footer style={{ textAlign: 'center', }} >
            Ant Design ©2018 Created by Ant UED
          </Footer>
        </Layout>
      </Layout>
    </Layout>
  )
};


export default App;