import { Step, StepLabel, Stepper } from '@mui/material'
import React from 'react'

const steps = [
    'Placed',
    'Order Confirmed',
    'Shipped',
    'Out For Delivery',
    'Delivered'
]

const OrderTraker = ({ activeStep }) => {
    return (
        <div className='w-full'>
            <Stepper activeStep={activeStep} alternativeLabel>
                {steps.map(label =>
                    <Step>
                        <StepLabel sx={{ color: '#9155F', fontSize: '44px' }}></StepLabel>
                    </Step>
                )}
            </Stepper>
        </div >
    )
}

export default OrderTraker