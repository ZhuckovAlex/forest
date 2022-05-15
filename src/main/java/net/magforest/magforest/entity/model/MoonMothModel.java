package net.magforest.magforest.entity.model;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.magforest.magforest.entity.custom.MoonMothEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MoonMothModel <T extends MoonMothEntity> extends EntityModel<T> {
	private final ModelRenderer legs;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer body_r2;
	private final ModelRenderer head;
	private final ModelRenderer rightWing;
	private final ModelRenderer cube_r1;
	private final ModelRenderer leftWing;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public MoonMothModel() {
		textureWidth = 48;
		textureHeight = 48;

		legs = new ModelRenderer(this);
		legs.setRotationPoint(2.0F, 22.0F, 0.0F);
		legs.setTextureOffset(0, 18).addBox(-3.0F, -5.0F, -4.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
		legs.setTextureOffset(32, 17).addBox(-3.0F, -5.0F, -2.5F, 3.0F, 1.0F, 0.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.5F, 19.0F, 0.0F);
		body.setTextureOffset(28, 9).addBox(-1.5F, -4.0F, -5.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(0, 3).addBox(-1.0F, -3.5F, -2.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(1.4237F, -3.75F, -6.2163F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, -0.1222F, -0.3927F, 0.0F);
		body_r1.setTextureOffset(0, 14).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

		body_r2 = new ModelRenderer(this);
		body_r2.setRotationPoint(-1.4237F, -3.75F, -6.2163F);
		body.addChild(body_r2);
		setRotationAngle(body_r2, -0.1222F, 0.3927F, 0.0F);
		body_r2.setTextureOffset(8, 14).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);


		rightWing = new ModelRenderer(this);
		rightWing.setRotationPoint(-1.25F, 15.0F, -3.625F);
		rightWing.setTextureOffset(18, 0).addBox(-5.7146F, 0.2785F, -0.9227F, 6.0F, 0.0F, 3.0F, 0.0F, false);
		rightWing.setTextureOffset(16, 17).addBox(-4.9646F, 0.2785F, -1.9227F, 3.0F, 0.0F, 1.0F, 0.0F, false);
		rightWing.setTextureOffset(0, 17).addBox(-4.9646F, 0.2785F, 2.0773F, 3.0F, 0.0F, 1.0F, 0.0F, false);
		rightWing.setTextureOffset(6, 18).addBox(-6.7146F, 0.2785F, -0.4227F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-0.7464F, 0.5749F, 5.114F);
		rightWing.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.096F, -0.0083F, -0.0031F);
		cube_r1.setTextureOffset(14, 3).addBox(0.3904F, -0.5053F, -0.516F, 1.0F, 0.0F, 5.0F, 0.0F, false);
		cube_r1.setTextureOffset(16, 14).addBox(-1.6096F, -0.5053F, -0.516F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		cube_r1.setTextureOffset(14, 9).addBox(-2.6096F, -0.5053F, -3.516F, 4.0F, 0.0F, 3.0F, 0.0F, false);

		leftWing = new ModelRenderer(this);
		leftWing.setRotationPoint(2.0F, 15.0F, -3.3F);


		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(1.25F, 0.1F, 4.7F);
		leftWing.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1056F, 0.1567F, 0.011F);
		cube_r2.setTextureOffset(0, 9).addBox(-1.25F, 0.0F, -3.5F, 4.0F, 0.0F, 3.0F, 0.0F, false);
		cube_r2.setTextureOffset(24, 14).addBox(-0.25F, 0.0F, -0.5F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(26, 3).addBox(-1.25F, 0.0F, -0.5F, 1.0F, 0.0F, 5.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(4.75F, 0.0F, -0.2F);
		leftWing.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.0524F, 0.1047F, -0.0524F);
		cube_r3.setTextureOffset(10, 18).addBox(1.25F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r3.setTextureOffset(8, 17).addBox(-2.5F, 0.0F, 1.5F, 3.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r3.setTextureOffset(24, 17).addBox(-2.5F, 0.0F, -2.5F, 3.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 0).addBox(-4.75F, 0.0F, -1.5F, 6.0F, 0.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightWing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftWing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}